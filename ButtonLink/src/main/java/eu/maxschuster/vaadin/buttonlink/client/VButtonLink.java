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

package eu.maxschuster.vaadin.buttonlink.client;

import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.DOM;
import com.vaadin.client.ui.VLink;

/**
 * @author Max Schuster
 */
public class VButtonLink extends VLink {
    
    public final Element wrapper = DOM.createSpan();

    public VButtonLink() {
        super();
        setElement(anchor);
        anchor.appendChild(wrapper);
        wrapper.appendChild(captionElement);
        setStyleName(CLASSNAME);
    }
    
    @Override
    public void setStyleName(String style) {
        super.setStyleName(style);
        if (wrapper != null) {
            wrapper.setClassName(getStylePrimaryName() + "-wrap");
        }
        if (captionElement != null) {
            captionElement.setClassName(getStylePrimaryName() + "-caption");
        }
    }

    @Override
    public void setStylePrimaryName(String style) {
        super.setStylePrimaryName(style);
        if (wrapper != null) {
            wrapper.setClassName(getStylePrimaryName() + "-wrap");
        }
        if (captionElement != null) {
            captionElement.setClassName(getStylePrimaryName() + "-caption");
        }
    }

    @Override
    public void onClick(ClickEvent event) {
            super.onClick(event);
            getElement().focus();
    }
}
