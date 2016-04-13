import Ember from 'ember';

export default Ember.Route.extend({
model(){
	let userList = [{
		Name: "User 1"
	},
	{	
		Name: "User 2"},
	{
		Name: "User 3"	
	},
	{
		Name: "User 4"
	}];
	return userList;
}
});
