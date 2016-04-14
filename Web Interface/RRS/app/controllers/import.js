import Ember from 'ember';

// var FileChecker = Ember.Object.extend(
// {
// 	isBinaryFile: function(bytes, size)
// 	{
// 	  if(size > 1024)
// 	  {
// 	  	size = 1024;
// 	  }

// 	  var ascii = 0, other = 0;

// 	  for(var i = 0; i < size; i++)
// 	  {
// 	  	var b = bytes[i];
// 	  	if(b < String.fromCharCode(0x09))
// 	  	{
// 	  		return true;
// 	  	}

// 	  	if(b == String.fromCharCode(0x09) || b == String.fromCharCode(0x0A) || b == String.fromCharCode(0x0C) || b == String.fromCharCode(0x0D))
// 	  	{
// 	  		ascii++;
// 	  	}
// 	  	else if(b >= String.fromCharCode(0x20) && b <= String.fromCharCode(0x7E))
// 	  	{
// 	  		ascii++;
// 	  	}
// 	  	else
// 	  	{
// 	  		other++;
// 	  	}
// 	  }

// 	  if(other == 0)
// 	  {
// 	  	return false;
// 	  }

// 	  return 100 * other / (ascii + other) > 95;
// 	}
// });

export default Ember.Controller.extend(
{
	fileName: null,
	actions:
	{
/**
* @function [fileChange] 
* Executed when the file is either dragged or chosen to upload. Just splits the path into the name of the file with the extension and determines OS to do this.
*/
		fileChange()
		{
			var OSName="Unknown OS";
			if (navigator.appVersion.indexOf("Win") !== -1)
			{
				OSName="Windows";
			}

			var file = document.getElementById('file-choose').value;
			var splArray;

			if(OSName === "Windows")
			{
				splArray = file.split('\\');
			}
			else
			{
				splArray = file.split('\/');
			}

			file = splArray[splArray.length - 1];
			this.set('fileName', file);
			document.getElementById('resets').style.visibility = "visible";

			if(this.get('fileName') == "")
				document.getElementById('resets').style.visibility = "hidden";
		},
/**
* @function [reset]
* Resets the fileName to an empty string and hides the error div.
*/
		reset()
		{
			this.set('fileName', "");
			document.getElementById('file-choose').value = "";
			document.getElementById('resets').style.visibility = "hidden";
			document.getElementById("error").innerHTML = "";
		},
/**
* @function [isCSV]
* Determines if the file is a csv file or not by just checking the file extension.
*/
		isCSV()
		{
			// var isBinary = false;
			// var reader = new FileReader();
			// reader.onload = readSuccess;
			// function readSuccess(event)
			// {
			// 	var contents = event.target.result;
			// 	var fileCheck = FileChecker.create();
			// 	// isBinary = fileCheck.isBinaryFile(contents, document.getElementById('file-choose').files[0].size);
			// };

			// reader.onerror = function(event)
			// {
			// 	console.error("File could not be read! Code " + event.target.error.code);
			// };

			// reader.readAsBinaryString(document.getElementById('file-choose').files[0]);
			if(document.getElementById('file-choose').value != null/* && isBinary == false*/)
			{
				var file = this.get('fileName').split('.');

				if(file[file.length - 1] === "csv")
				{
					return true;
				}
				else
				{
					document.getElementById("error").innerHTML = "Error! Invalid File Format";
					return false;
				}
			}
			else
			{
				return false;
			}
			// else if(isBinary == true)
			// {
			// 	document.getElementById("error").innerHTML = "Error! Invalid File Format";
			// 	return false;
			// }
		}
	}
});
