/**
 *  Toggles the specified switch every n minutes where n is a specified period between 1 and 60.
 */
definition(
    name: "Switch Cycle",
    namespace: "zeande",
    author: "zeande",
    description: "Cycles simulated switch periodically",
    category: "Convenience",
    iconUrl: "https://s3.amazonaws.com/smartapp-icons/Meta/light_motion-outlet.png",
    iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Meta/light_motion-outlet@2x.png"
)

preferences {
    section("Trigger this switch...") {
        input "switch1", "capability.switch", title: "Which switch?", multiple: true, required: true
    }
    
    section("Cycle duration...") {
    	input "period", "number", title: "Period in minutes?", required: true, range:"1..59"
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
