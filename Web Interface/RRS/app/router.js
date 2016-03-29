import Ember from 'ember';
import config from './config/environment';

const Router = Ember.Router.extend({
  location: config.locationType
});

Router.map(function() {
  this.route('home', {path: '/'});

  this.route('persons', { path: '/persons' }, function() {
    this.route('edit', { path: '/edit' });
    this.route('add', { path: '/add' });
	this.route('add-research', { path: '/add-research' });
  });
});

export default Router;
