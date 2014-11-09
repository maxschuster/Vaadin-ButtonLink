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

package eu.maxschuster.vaadin.buttonlink;

import com.vaadin.server.Resource;
import com.vaadin.shared.ui.BorderStyle;
import com.vaadin.ui.Link;
import eu.maxschuster.vaadin.buttonlink.client.ButtonLinkState;

/**
 *
 * @author Max
 */
public class ButtonLink extends Link {

    public ButtonLink() {
    }

    public ButtonLink(String caption, Resource resource) {
        super(caption, resource);
    }

    public ButtonLink(String caption, Resource resource, String targetName,
            int width, int height, BorderStyle border) {
        super(caption, resource, targetName, width, height, border);
    }

    @Override
    protected ButtonLinkState getState(boolean markAsDirty) {
        return (ButtonLinkState) super.getState(markAsDirty);
    }

    @Override
    protected ButtonLinkState getState() {
        return (ButtonLinkState) super.getState();
    }

    /**
     * Sets the component's icon and alt text.
     *
     * An alt text is shown when an image could not be loaded, and read by
     * assisitve devices.
     *
     * @param icon the icon to be shown with the component's caption.
     * @param iconAltText String to use as alt text
     */
    public void setIcon(Resource icon, String iconAltText) {
        super.setIcon(icon);
        getState().iconAltText = iconAltText == null ? "" : iconAltText;
    }

    /**
     * Returns the icon's alt text.
     *
     * @return String with the alt text
     */
    public String getIconAlternateText() {
        return getState(false).iconAltText;
    }

    public void setIconAlternateText(String iconAltText) {
        getState().iconAltText = iconAltText;
    }

}
