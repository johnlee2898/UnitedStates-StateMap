# UnitedStates-StateMap for Android
Display highlight specific state with specific color.

# Requirements
The library requires Android **API Level 21+**.

# Screenshots:
![Main screen](/screenshot/Screenshot_20180627-154606_UnitedStatesStateMap.jpg) ![Main screen](/screenshot/Screenshot_20180627-155225_UnitedStatesStateMap.jpg)

# Public APIs:
fun showHighlightStatesWithColor(states: Array<String>?, color: String)
  
For example：

"#az" ---- Arizona.

"#wa" ---- Washington.

var states: Array<String> = arrayOf("#az", "#pa", "#wa", "#me", "#la", "#tn", "#fl", "#sd", "#in")

showHighlightStatesWithColor(states, "#303f9f")
