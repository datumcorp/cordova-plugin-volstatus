#import <Foundation/Foundation.h>
#import <Cordova/CDV.h>
#import "SharkfoodMuteSwitchDetector.h"



@interface VolStatus : CDVPlugin
{
    SharkfoodMuteSwitchDetector* detector;
}

@property (nonatomic, retain) SharkfoodMuteSwitchDetector* detector;

- (void)getVolStatus:(CDVInvokedUrlCommand*)command;

@end