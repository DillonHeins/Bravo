import Model from 'ember-data/model';

export default Model.extend({
  name: DS.attr(),
  category: DS.attr(),
  reseacher: DS.attr()
});
