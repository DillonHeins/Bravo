import Ember from 'ember';

export function genButton(params) {
  if(params[0] == params[1])
    return new Ember.Handlebars.SafeString('<div class="btn-group"><a class="btn btn-danger" href="' + params[2] + '.bib" download>Export to Bib</a></div>');
}

export default Ember.Helper.helper(genButton);
