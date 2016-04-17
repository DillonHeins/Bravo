export function genButton(params)
{
  if(params[0] == params[1])
    return new Ember.Handlebars.SafeString('<a class="btn btn-danger" href="' + params[2] + '.bib" download>Export to Bibtex</a>');
}

export default Ember.Helper.helper(genButton);
