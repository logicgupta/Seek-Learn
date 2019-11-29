Seek & Learn
===================================

This application provides a completed version of the OpenTok [Basic Video Chat tutorial](https://tokbox.com/developer/tutorials/android/) for Android (differing only in some additional validation checks). Upon deploying this sample application, you should be able to have two way audio and video communication using OpenTok.

Note that you will need a valid TokBox account for this and all other TokBox samples and tutorials.

### Quick Deploy
====================================

##### 1. Git clone this repository
Clone this repository using:

```git clone git@github.com:logicgupta/Seek-Learn.git```

in your terminal. Then, using [Android Studio](https://developer.android.com/studio/index.html), open the project in the Basic-Video-Chat folder.

##### 2. Configure the app 
In `OpenTokConfig.java`, configure the `API_KEY`, `SESSION_ID`, and `TOKEN` variables. You can obtain these values from your [TokBox account](https://tokbox.com/account/#/). Make sure that your `TOKEN` isn't expired.

Note that we are hard coding these values in for demonstration purposes only. Your production app should not do this.


##### 3. Run the app
That's it!
