import Ember from 'ember';

var FileChecker = Ember.Object.extend(
{
	isBinaryFile: function(bytes, size) 
	{
	  if(size > 1024)
	  {
	  	size = 1024;
	  }

	  var ascii = 0, other = 0;

	  for(var i = 0; i < bytes.length; i++)
	  {
	  	var b = bytes[i];
	  	if(b < String.fromCharCode(0x09))
	  	{
	  		return true;
	  	}

	  	if(b == String.fromCharCode(0x09) || b == String.fromCharCode(0x0A) || b == String.fromCharCode(0x0C) || b == String.fromCharCode(0x0D))
	  	{
	  		// console.log("1) ascii++");
	  		ascii++;
	  	}
	  	else if(b >= String.fromCharCode(0x20) && b <= String.fromCharCode(0x7E))
	  	{
	  		// console.log("2) ascii++");
	  		ascii++;
	  	}
	  	else 
	  	{
	  		// console.log("1) other++");
	  		other++;
	  	}
	  }

	  if(other == 0)
	  {
	  	return false;
	  }

	  return 100 * other / (ascii + other) > 95;
	}
});

export default Ember.Controller.extend(
{
	fileName: null,
	actions:
	{
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
		reset()
		{
			this.set('fileName', "");
			document.getElementById('file-choose').value = "";
			document.getElementById('resets').style.visibility = "hidden";
			document.getElementById("error").innerHTML = "";
		},
		isCSV()
		{
			var isBinary = false;
			var reader = new FileReader();
			reader.onload = function(event) 
			{
				var contents = event.target.result;
				var fileCheck = FileChecker.create();
				isBinary = fileCheck.isBinaryFile(contents, document.getElementById('file-choose').files[0].size);
			};

			reader.onerror = function(event) 
			{
				console.error("File could not be read! Code " + event.target.error.code);
			};

			reader.readAsText(document.getElementById('file-choose').files[0]);
			if(document.getElementById('file-choose').value != null && isBinary == false)
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
			else if(isBinary == true)
			{
				document.getElementById("error").innerHTML = "Error! Invalid File Format";
				return false;
			}
		}
	}
});