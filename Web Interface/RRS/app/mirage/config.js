export default function() {
  // add new publication
  this.post("/publications/add/", function(db, request) {
    let obs = request.requestBody.split('&');
    let jsonObj = {};

    for (var i = 0; i < obs.length; i++) {
      var tmp = (obs[i] + "").split('=');
      tmp[0] = unescape(tmp[0]);
      tmp[0] = tmp[0].replace("[]", "");
      var t = tmp[1];

      while (tmp[1].replace("+", " ") !== t) {
        t = tmp[1];
        tmp[1] = tmp[1].replace("+", " ");
      }

      tmp[1] = unescape(tmp[1]);

      if (jsonObj[tmp[0]] === undefined){
        jsonObj[tmp[0]] = tmp[1];
      }
      else {
        jsonObj[tmp[0]] = new Array(tmp[1]).concat(jsonObj[tmp[0]]);
      }
    }

    var publication = db.publications.insert(jsonObj);

    return {
      data: {
        type: 'publications',
        attributes: publication
      }
    };
  });

    this.post("/publications/edit/", function(db, request) {
    let obs = request.requestBody.split('&');
    let jsonObj = {};

    for (var i = 0; i < obs.length; i++) {
      var tmp = (obs[i] + "").split('=');
      tmp[0] = unescape(tmp[0]);
      tmp[0] = tmp[0].replace("[]", "");
      var t = tmp[1];

      while (tmp[1].replace("+", " ") !== t) {
        t = tmp[1];
        tmp[1] = tmp[1].replace("+", " ");
      }

      tmp[1] = unescape(tmp[1]);

      if (jsonObj[tmp[0]] === undefined){
        jsonObj[tmp[0]] = tmp[1];
      }
      else {
        jsonObj[tmp[0]] = new Array(tmp[1]).concat(jsonObj[tmp[0]]);
      }
    }

    var publication = db.publications.insert(jsonObj);

    return {
      data: {
        type: 'publications',
        attributes: publication
      }
    };
  });

  // add new person
  this.post("/people/add/", function(db, request) {
    let obs = request.requestBody.split('&');
    let jsonObj = {};

    for (var i = 0; i < obs.length; i++) {
      var tmp = (obs[i] + "").split('=');
      tmp[0] = unescape(tmp[0]);
      tmp[0] = tmp[0].replace("[]", "");
      var t = tmp[1];

      while (tmp[1].replace("+", " ") !== t) {
        t = tmp[1];
        tmp[1] = tmp[1].replace("+", " ");
      }

      tmp[1] = unescape(tmp[1]);

      if (jsonObj[tmp[0]] === undefined){
        jsonObj[tmp[0]] = tmp[1];
      }
      else {
        jsonObj[tmp[0]] = new Array(tmp[1]).concat(jsonObj[tmp[0]]);
      }
    }

    var person = db.people.insert(jsonObj);

    return {
      data: {
        type: 'people',
        attributes: person
      }
    };
  });

  // add new group
  this.post("/people/addresearch/", function(db, request) {
    let obs = request.requestBody.split('&');
    let jsonObj = {};

    for (var i = 0; i < obs.length; i++) {
      var tmp = (obs[i] + "").split('=');
      tmp[0] = unescape(tmp[0]);
      tmp[0] = tmp[0].replace("[]", "");
      var t = tmp[1];

      while (tmp[1].replace("+", " ") !== t) {
        t = tmp[1];
        tmp[1] = tmp[1].replace("+", " ");
      }

      tmp[1] = unescape(tmp[1]);

      if (jsonObj[tmp[0]] === undefined){
        jsonObj[tmp[0]] = tmp[1];
      }
      else {
        jsonObj[tmp[0]] = new Array(tmp[1]).concat(jsonObj[tmp[0]]);
      }
    }

    var researchgroup = db.researchgroups.insert(jsonObj);

    return {
      data: {
        type: 'researchgroups',
        attributes: researchgroup
      }
    };
  });

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
