import Ember from 'ember';
import config from './config/environment';

const Router = Ember.Router.extend({
  location: config.locationType
});

Router.map(function() {
  this.route('publications', function() {
    this.route('view', {path: '/view/:publication_id'});
    this.route('edit', {path: '/edit/:publication_id'});
    this.route('add');
  });
  this.route('people', function() {
    this.route('add');
    this.route('view', {path: '/view/:person_id'});
    this.route('addresearch');
    this.route('edit', {path: '/edit/:person_id'});
  });
  this.route('import');

  this.route('reports', function() {
    this.route('query');
    this.route('view');
  });
  this.route('home', {path: '/'});
});

export default Router;
