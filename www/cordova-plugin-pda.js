var exec = require('cordova/exec');

exports.ScanerUtil = {
    readScanerText: function (arg0, success, error) {
        exec(success, error, 'ScanerUtil', 'readScanerText', [arg0]);
    }
  }
