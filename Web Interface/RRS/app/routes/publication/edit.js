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
            {
                pubname: [{ 
                    name: "Publication 1",
                }, { 
                    name: "Publication 2",
                },{ 
                    name: "Publication 3",
                },{ 
                    name: "Publication 4",
                }],
            },
            
        ];
        return todos;
  }

});
