#import "VolStatus.h"

@implementation VolStatus

@synthesize detector;

- (void)getVolStatus:(CDVInvokedUrlCommand*)command
{
	CDVPluginResult* pluginResult = nil;
    self.detector = [SharkfoodMuteSwitchDetector shared];
    if (self.detector == nil) {
    	pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR];
  	} else {
    	if (self.detector.isMute) {
    		pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:@"SILENT"];
  		}else{
  			pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:@"NORMAL"];
  		}
  	}
  	[self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];

}

@end
