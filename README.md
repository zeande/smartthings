# zeande smartthings
This is a collection of various utilities to be used with a smartthings hub. Many of them focus on utility apps related to hydroponic gardening, which revolves around cycling switches at periodic times throughout the day.

In my case, I am using an Alexa to control a number of smart switches and plugs. devicetypes/simulated-alexa-switch is a simulated switch device type that can be published and then registered in Alexa, which sees it as a motion sensor. It can than be used in Alexa routines to control other devices.