//find out why its not working?
import Ember from 'ember';

export default Ember.Route.extend({
    model() {
        let todos = [
            {
                state: [{ 
                    state: "inProgress",
                }, { 
                    state: "Submitted",
                }, { 
                    state: "Accepted",
                }, { 
                     state: "InRevision",
                }, {
                    state: "Abandoned",
                }],
            },
            {
                name: [{ 
                    name: "John Snow",
                }, { 
                    name: "Jane Doe",
                }],
            },
            
        ];
        return todos;
  }

});
