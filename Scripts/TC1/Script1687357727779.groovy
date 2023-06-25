import java.awt.image.BufferedImage

import javax.imageio.ImageIO

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

TestObject makeTestObject(String id, String xpath) {
	TestObject tObj = new TestObject(id)
	tObj.addProperty("xpath", ConditionType.EQUALS, xpath)
	return tObj	
}

String url = 'https://www.adm.com/en-us/insights-and-innovation/formulation-challenges/sugar-reduction/'
String fileName = "sugarReduction.png"
File png = new File("./" + fileName)

WebUI.openBrowser('')
WebUI.setViewPortSize(1200, 800)
WebUI.navigateToUrl(url)

// now we should wait for the page to load completely before taking its screenshot
TestObject footerLogo = makeTestObject('footerLogo', '//footer//img[@alt="ADM Logo Footer"]')
WebUI.verifyElementPresent(footerLogo, 10)
// now the page has been loaded complate

// let's take a full page screenshot using the built-in keyword 
WebUI.takeFullPageScreenshotAsCheckpoint(png.toString())

// done; close the browser
WebUI.closeBrowser()

// show information
BufferedImage bi = ImageIO.read(png)
WebUI.comment("png image width=" + bi.getWidth())
WebUI.comment("png image height=" + bi.getHeight())
WebUI.comment("png file path=" + png.toString())
WebUI.comment("png file length=" + png.length())
