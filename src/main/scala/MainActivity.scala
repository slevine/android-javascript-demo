package net.blue64.android

import _root_.android.app.Activity
import _root_.android.os.Bundle
import android.util.Log
import android.webkit.{ConsoleMessage, WebChromeClient, WebView}


class MainActivity extends Activity with TypedActivity {
  override def onCreate(bundle: Bundle) {
    // Implementation given to Javascript
    object jsFun {
      // function javascript can call
      def sdkVersion() = android.os.Build.VERSION.SDK
    }

    super.onCreate(bundle)
    val webView: WebView = new WebView(this)

    // Load page from assets
    webView loadUrl ("file:///android_asset/index.html")
    webView.getSettings setJavaScriptEnabled(true)
    webView addJavascriptInterface(jsFun, "Android")

    // Impl to intercept all js console.log calls
    webView setWebChromeClient new WebChromeClient {
      override def onConsoleMessage(consoleMessage: ConsoleMessage): Boolean = {
        val msg = new StringBuilder(consoleMessage
          .messageLevel.name).append('\t')
          .append(consoleMessage.message).append('\t')
          .append(consoleMessage.sourceId).append(" (")
          .append(consoleMessage.lineNumber).append(")\n")
        if (consoleMessage.messageLevel == ConsoleMessage.MessageLevel.ERROR)
          Log.e("JavascriptExmple", msg.toString())
        else
          Log.d("JavascriptExmple", msg.toString())
        true
      }
    }
    setContentView(webView)

  }
}
