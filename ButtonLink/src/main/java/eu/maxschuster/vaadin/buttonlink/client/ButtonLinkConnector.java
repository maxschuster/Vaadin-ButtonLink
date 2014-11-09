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
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.Icon;
import com.vaadin.client.ui.link.LinkConnector;
import com.vaadin.shared.ui.Connect;

import eu.maxschuster.vaadin.buttonlink.ButtonLink;

/**
 * @author Max Schuster
 */
@Connect(ButtonLink.class)
public class ButtonLinkConnector extends LinkConnector {

    @Override
    public VButtonLink getWidget() {
        return (VButtonLink) super.getWidget();
    }

    @Override
    public ButtonLinkState getState() {
        return (ButtonLinkState) super.getState();
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        VButtonLink widget = getWidget();
        Element anchor = widget.anchor;
        Element caption = widget.captionElement;
        Element wrapper = widget.wrapper;
        
        anchor.appendChild(caption);
        if (widget.icon != null) {
            anchor.appendChild(widget.icon.getElement());
        }
        
        super.onStateChanged(stateChangeEvent);
        
        if (widget.icon != null) {
            wrapper.appendChild(widget.icon.getElement());
        }
        wrapper.appendChild(caption);
        
        if (widget.icon != null) {
            wrapper.removeChild(
                    widget.icon.getElement());
            widget.icon = null;
        }
        Icon icon = getIcon();
        if (icon != null) {
            widget.icon = icon;
            icon.setAlternateText(getState().iconAltText);
            wrapper.insertBefore(icon.getElement(),
                    widget.captionElement);
        }
    }
    
}
