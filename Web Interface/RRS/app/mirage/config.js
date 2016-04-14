export default function() {
  //single publication
  this.get('/publications/:id', function(db, request) {
    let id = request.params.id;

    return {
      data: {
        type: 'publications',
        id: id,
        attributes: db.publications.find(id)
      }
    };
  });

  //collection of publications
  this.get('/publications', function(db, request) {
    return {
      data: db.publications.map(attrs => ({
        type: 'publications',
        id: attrs.id,
        attributes: attrs
      }))
    };
  });

  //single person
  this.get('/people/:id', function(db, request) {
    let id = request.params.id;

    return {
      data: {
        type: 'people',
        id: id,
        attributes: db.people.find(id)
      }
    };
  });

  //collection of people
  this.get('/people', function(db, request) {
    return {
      data: db.people.map(attrs => ({
        type: 'people',
        id: attrs.id,
        attributes: attrs
      }))
    };
  });

  // collection of reports
  this.get('/reports', function(db, request) {
    return {
      data: db.reports.map(attrs => ({
        type: 'reports',
        id: attrs.id,
        attributes: attrs
      }))
    };
  });
}
