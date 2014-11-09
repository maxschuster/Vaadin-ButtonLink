/*
 * Copyright 2014 Max Schuster
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package eu.maxschuster.vaadin.buttonlink.demo;

import java.util.Arrays;
import java.util.List;

import eu.maxschuster.vaadin.buttonlink.ButtonLink;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.Page.UriFragmentChangedListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.Page.UriFragmentChangedEvent;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

@Title("ButtonLink Add-on Demo")
@SuppressWarnings("serial")
@Theme("demo-valo")
public class DemoUI extends UI {

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(
            productionMode = true,
            ui = DemoUI.class,
            widgetset = "eu.maxschuster.vaadin.buttonlink.demo.DemoWidgetSet"
    )
    public static class Servlet extends VaadinServlet {
    }

    private final List<String> themes = Arrays.asList(
            "demo-valo",
            "demo-reindeer",
            "demo-runo",
            "demo-chameleon"
    );

    private final String defaultTheme = themes.get(0);

    private final ComboBox themeSelect = new ComboBox("Themes:", themes);

    @Override
    protected void init(VaadinRequest request) {

        final VerticalLayout wrapper = new VerticalLayout();
        wrapper.setSizeFull();
        setContent(wrapper);

        // Show it in the middle of the screen
        final VerticalLayout layout = new VerticalLayout();
        layout.setSpacing(true);
        layout.setSizeUndefined();
        wrapper.addComponent(layout);
        wrapper.setComponentAlignment(layout, Alignment.MIDDLE_CENTER);

        final Label themeName = new Label();
        themeName.setCaption("Current Theme:");
        themeName.addStyleName("h1");
        layout.addComponent(themeName);

        Label waring = new Label("<strong>Attention:</strong><br />\nChanging the theme may take a few seconds!");
        waring.setContentMode(ContentMode.HTML);
        layout.addComponent(waring);

        getPage().addUriFragmentChangedListener(new UriFragmentChangedListener() {

            @Override
            public void uriFragmentChanged(UriFragmentChangedEvent event) {
                String fragment = event.getUriFragment().replace("!", "");
                if (fragment.isEmpty()) {
                    fragment = defaultTheme;
                }
                loadTheme(fragment);
            }
        });

        themeSelect.setSizeFull();
        themeSelect.setNullSelectionAllowed(false);
        themeSelect.addValueChangeListener(new ValueChangeListener() {

            @Override
            public void valueChange(ValueChangeEvent event) {
                String fragment = "!" + themeSelect.getValue();
                getPage().setUriFragment(fragment);
            }
        });
        layout.addComponent(themeSelect);
        layout.setComponentAlignment(themeSelect, Alignment.BOTTOM_CENTER);

        final HorizontalLayout comparsionLayout = new HorizontalLayout();
        comparsionLayout.setSpacing(true);
        layout.addComponent(comparsionLayout);
        layout.setComponentAlignment(comparsionLayout, Alignment.TOP_CENTER);

        final Button button = new Button("This is a \"normal\" Button", new Button.ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                Notification.show("Hello World!");
            }
        });
        comparsionLayout.addComponent(button);
        comparsionLayout.setComponentAlignment(button, Alignment.MIDDLE_RIGHT);

        // Initialize our new UI component
        final ButtonLink componentLink = new ButtonLink("This is a ButtonLink", new ExternalResource("https://vaadin.com"));
        componentLink.setTargetName("_blank");
        componentLink.setDescription("Visit vaadin.com in a new tab or window.");
        comparsionLayout.addComponent(componentLink);
        comparsionLayout.setComponentAlignment(componentLink, Alignment.MIDDLE_LEFT);

        themeName.setPropertyDataSource(themeSelect);

        String fragment = getPage().getUriFragment();

        loadTheme(fragment == null || fragment.replace("!", "").isEmpty() ? defaultTheme : fragment.replace("!", ""));
    }

    private void loadTheme(String theme) {
        setTheme(theme);
        themeSelect.setValue(theme);
    }

}
