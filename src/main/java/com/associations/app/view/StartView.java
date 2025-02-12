package com.associations.app.view;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.associations.app.constants.CSSConstants;
import com.associations.app.constants.TextConstants;
import com.associations.app.entity.user.User;
import com.associations.app.userinfo.UserInfo;
import com.associations.app.view.association.game.StartAssociationGameView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.i18n.LocaleChangeEvent;
import com.vaadin.flow.i18n.LocaleChangeObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.spring.annotation.UIScope;

@RouteAlias(value = "", layout = MainView.class)
@Route(value = "start", layout = MainView.class)
@PageTitle("Start")
@CssImport("./styles/shared-styles.css")
@UIScope
@Component
public class StartView extends VerticalLayout implements LocaleChangeObserver
{

	private static final long serialVersionUID = 1686035666342372757L;

	private H3 headline = new H3();
	private H4 personalLabel = new H4();
	private Button button = new Button();

	@Autowired
	private UserInfo userInfo;

	@PostConstruct
	public void init()
	{
		addClassName(CSSConstants.CENTERED_CONTENT);

		button.addClickListener(event -> UI.getCurrent().navigate(StartAssociationGameView.class));
		button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

		updateUi();
	}

	public void updateUi()
	{
		removeAll();
		headline.setText(getTranslation("welcome") + TextConstants.TITLE);

		add(headline, personalLabel);
		
		preparePersonalLabel();
	}

	private void preparePersonalLabel()
	{
		User user = userInfo.getLoggedInUser();
		if (user != null)
		{
			personalLabel.setText(getTranslation("hi") + user.getFirstName() + "! " + getTranslation("welcomeText"));
			button.setText(getTranslation("start"));
			add(button);
		} else
		{
			personalLabel.setText(getTranslation("welcomeText"));
		}
	}

	@Override
	public void localeChange(LocaleChangeEvent event)
	{
		headline.setText(getTranslation("welcome") + TextConstants.TITLE);
		button.setText(getTranslation("start"));
		preparePersonalLabel();
	}

}
