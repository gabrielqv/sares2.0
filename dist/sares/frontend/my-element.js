import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-accordion/src/vaadin-accordion.js';

class MyElement extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-button theme="primary">
  Primary 
</vaadin-button>
<vaadin-accordion></vaadin-accordion>
`;
    }

    static get is() {
        return 'my-element';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(MyElement.is, MyElement);
