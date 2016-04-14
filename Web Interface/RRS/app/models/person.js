import DS from 'ember-data';

export default DS.Model.extend({
  title: DS.attr(),
  name: DS.attr(),
  surname: DS.attr(),
  organization: DS.attr(),
  email: DS.attr(),
  field: DS.attr()
});
