/**
 *  Copyright 2015 SmartThings
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 */
metadata {
    definition (name: "Simulated Alexa Switch", namespace: "alexaintegration", author: "zeande") {
        capability "Switch"
        capability "Sensor"
        capability "Motion Sensor"
        
        command "on"
        command "off"
        command "active"
		command "inactive"
    }
    
    simulator {
		status "active": "motion:active"
		status "inactive": "motion:inactive"
	}

	tiles {
		standardTile("motion", "device.motion", width: 2, height: 2) {
			state("inactive", label:'no motion', icon:"st.motion.motion.inactive", backgroundColor:"#cccccc", action: "active")
			state("active", label:'motion', icon:"st.motion.motion.active", backgroundColor:"#00A0DC", action: "inactive")
		}
		main "motion"
		details "motion"
	}
}

def parse(description) {
}

def on() {
    sendEvent(name: "switch", value: "on")
    sendEvent(name: "contact", value: "open")
	sendEvent(name: "motion", value: "active")
}

def off() {
    sendEvent(name: "switch", value: "off")
    sendEvent(name: "contact", value: "closed")
	sendEvent(name: "motion", value: "inactive")
}

def active() {
    sendEvent(name: "switch", value: "on")
    sendEvent(name: "contact", value: "open")
	sendEvent(name: "motion", value: "active")
}

def inactive() {
    sendEvent(name: "switch", value: "off")
    sendEvent(name: "contact", value: "closed")
	sendEvent(name: "motion", value: "inactive")
}