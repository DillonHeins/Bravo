import Ember from 'ember';
import config from './config/environment';

const Router = Ember.Router.extend({
  location: config.locationType
});

Router.map(function() {
  this.route('home', {path: '/'});

  //TODO: Create a route and add sub routes to it. E.g.:
  // this.route('publication', {path: '/publication'}, function () { // we have publications and as a sub route we have the add and edit pages
  //   this.route('add', { path: '/publication/add'});
  //   this.route('edit', { path: '/publication/edit'});
  // });

  this.route('reporting', { path: '/reporting' }, function() {
    this.route('query', { path: '/reporting/query' });
    this.route('view', { path: '/reporting/view' });
  });
});

export default Router;
