# Q5 - Android activity lifecycle

The main lifecycle callbacks are onCreate(), onStart(), onResume(), onPause(), onStop(), onRestart(), and onDestroy().

onCreate() initialises a new activity instance, including its views and state restoration from a supplied Bundle. onStart() makes the activity visible. onResume() puts it in the foreground and ready for user interaction; acquire resources that are needed while resumed.

onPause() runs when the activity loses foreground interaction, such as when another activity comes forward. Keep this callback brief and stop work that should not continue while paused. A paused activity can still be visible, including in multi-window use. onStop() runs when the activity is no longer visible, allowing it to release resources needed only while visible.

onRestart() runs when an activity returns from the stopped state, followed by onStart() and onResume(). onDestroy() runs when the instance is finishing or being destroyed for a configuration change; a replacement instance may then receive onCreate(). The system can kill the process without calling onDestroy(), so it must not be the only place where essential data is persisted.

onSaveInstanceState() can save transient UI state for later recreation, and onRestoreInstanceState() can restore it after onStart(); these support state restoration rather than representing additional core lifecycle states. Configuration changes commonly destroy and recreate the activity, while returning to an existing stopped instance uses onRestart().

Source: [Android activity lifecycle](https://developer.android.com/guide/components/activities/activity-lifecycle).
