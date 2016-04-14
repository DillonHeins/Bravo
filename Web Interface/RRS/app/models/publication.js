import DS from 'ember-data';

export default DS.Model.extend({
  	title: DS.attr(),
	group: DS.attr(),
	author: DS.attr(),
	type: DS.attr(),
	progress: DS.attr(),
	state: DS.attr(),
	due: DS.attr()
});
