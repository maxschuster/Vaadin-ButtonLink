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

import java.util.Arrays;

import com.vaadin.shared.ui.link.LinkState;
import java.util.LinkedList;

/**
 * @author Max Schuster
 */
public class ButtonLinkState extends LinkState {
    {
        primaryStyleName = "v-button";
        styles = new LinkedList<String>(Arrays.asList("buttonlink"));
    }
    public String iconAltText = "";
}
