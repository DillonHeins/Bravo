var MAX_BYTES = 2000;

function isBinaryCheck(bytes, size) 
{
  if (size === 0)
    return false;

  var suspicious_bytes = 0;
  var total_bytes = Math.min(size, MAX_BYTES);

  // UTF-8 BOM
  if (size >= 3 && bytes[0] == 0xEF && bytes[1] == 0xBB && bytes[2] == 0xBF) {
    return false;
  }

  // UTF-32 BOM
  if (size >= 4 && bytes[0] === 0x00 && bytes[1] === 0x00 && bytes[2] == 0xFE && bytes[3] == 0xFF) {
    return false;
  }

  // UTF-32 LE BOM
  if (size >= 4 && bytes[0] == 0xFF && bytes[1] == 0xFE && bytes[2] === 0x00 && bytes[3] === 0x00) {
    return false;
  }

  // GB BOM
  if (size >= 4 && bytes[0] == 0x84 && bytes[1] == 0x31 && bytes[2] == 0x95 && bytes[3] == 0x33) {
    return false;
  }

  // PDF
  if (total_bytes >= 4 && bytes[0] == 0x25 && bytes[1] == 0x50 && bytes[2] == 0x44 && bytes[3] ==  0x46) {
    return true;
  }

  // UTF-16 BE BOM
  if (size >= 2 && bytes[0] == 0xFE && bytes[1] == 0xFF) {
    return false;
  }

  // UTF-16 LE BOM
  if (size >= 2 && bytes[0] == 0xFF && bytes[1] == 0xFE) {
    return false;
  }

  for (var i = 0; i < total_bytes; i++) {
    if (bytes[i] === 0) { // NULL byte--it's binary!
      return true;
    }
    else if ((bytes[i] < 7 || bytes[i] > 14) && (bytes[i] < 32 || bytes[i] > 127)) {
      // UTF-8 detection
      if (bytes[i] > 193 && bytes[i] < 224 && i + 1 < total_bytes) {
          i++;
          if (bytes[i] > 127 && bytes[i] < 192) {
            continue;
          }
      }
      else if (bytes[i] > 223 && bytes[i] < 240 && i + 2 < total_bytes) {
          i++;
          if (bytes[i] > 127 && bytes[i] < 192 && bytes[i + 1] > 127 && bytes[i + 1] < 192) {
            i++;
            continue;
          }
      }
      suspicious_bytes++;
      // Read at least 32 bytes before making a decision
      if (i > 32 && (suspicious_bytes * 100) / total_bytes > 10) {
        return true;
      }
    }
  }

  if ((suspicious_bytes * 100) / total_bytes > 10) {
    return true;
  }

  return false;
}

var reader = new FileReader();
reader.onload = function(event) 
{
	var contents = event.target.result;
	console.log(contents);
	alert(isBinaryCheck(contents, document.getElementById('file-choose').files[0].size));
};

reader.onerror = function(event) 
{
	console.error("File could not be read! Code " + event.target.error.code);
};

import Ember from 'ember';
// import dragndrop from '../../node_modules/ember-drag-n-drop-upload/index';
export default Ember.Controller.extend(
{
	filePath: null,
	fileName: null,
	actions:
	{
		fileChange()
		{
			var OSName="Unknown OS";
			if (navigator.appVersion.indexOf("Win")!=-1) OSName="Windows";

			var file = document.getElementById('file-choose').value;
			this.set('filePath', file);
			var splArray;

			if(OSName == "Windows") 
				splArray = file.split('\\');
			else
				splArray = file.split('\/');

			file = splArray[splArray.length - 1];
			this.set('fileName', file);
			document.getElementById('resets').style.visibility = "visible";
		},
		reset()
		{
			this.set('fileName', "");
			document.getElementById('file-choose').value = "";
			document.getElementById('resets').style.visibility = "hidden";
		},
		isCSV()
		{
			reader.readAsText(document.getElementById('file-choose').files[0]);
			if(document.getElementById('file-choose').value != null)
			{
				// if(isBinaryFile(filePath))
				// {
				// 	alert("You cannot upload a file of this format");
				// 	return false;
				// }
				// else
				// {
					var file = this.get('fileName').split('.');
					alert(file);
					if(file[1] == "csv")
						return true;
					else
						return false;
				// }
			}
			alert(false);
		}
	}
});