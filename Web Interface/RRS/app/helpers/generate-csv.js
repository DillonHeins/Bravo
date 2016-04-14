import Ember from 'ember';

export function generateCSV(params) {
  var content = params[0] + ",";
  content += params[1] + ",";
  content += params[2] + ",";
  content += params[3] + ",";
  content += params[4] + ",";
  content += params[5];
  return "data:text/csv," + encodeURIComponent(content);
}

export default Ember.Helper.helper(generateCSV);
