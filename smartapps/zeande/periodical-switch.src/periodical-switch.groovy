/**
 *  Toggles the specified switch every n minutes where n is a specified period between 1 and 60.
 */
definition(
    name: "Periodical Switch",
    namespace: "zeande",
    author: "zeande",
    description: "Manages power state to the specified switch given a specified start and stop time as well as power-off settings.",
    category: "Terrarium",
    iconUrl: "https://s3.amazonaws.com/smartapp-icons/Meta/light_motion-outlet.png",
    iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Meta/light_motion-outlet@2x.png"
)

preferences {
    section("Trigger this switch...") {
        input "switch1", "capability.switch", title: "Which switch?", multiple: true, required: true
    }
    
    section("Start and stop times") {
    	input "start", "time", title: "Start time?", required: true
    	input "stop", "time", title: "Stop time?", required: true
    }
}

def installed()
{
    switch1.off()
    state.active = false
    handler()
}

def updated()
{
    switch1.off()
    state.active = false
    handler()
}

def handler()
{
    unschedule(toggle)
    schedule("0 0/${period} * * * ?", toggle)
}

def toggle()
{
    if (state.motion) {
        state.motion = false
        switch1.off()
    } else {
        state.motion = true
        switch1.on()
    }
}