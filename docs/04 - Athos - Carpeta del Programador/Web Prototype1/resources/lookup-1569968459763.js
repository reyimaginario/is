(function(window, undefined) {
  var dictionary = {
    "92cf4948-8c6e-4dd5-8a39-7599a75d8ae9": "10_todas",
    "f2d3e830-0c57-4266-8cb3-c7aad88023a4": "02_login",
    "c0d17f17-ba57-4c30-bad1-1947957f8999": "08_alta entrevistado",
    "4018d18a-b128-4823-ab26-14a3c4c5a0b2": "06_profile",
    "d7ef1bee-7ca1-4e95-8ebd-c869ed126f5b": "07_crear bateria",
    "5b33d8d1-2e3d-424b-b0b7-770d56c3b7ac": "05_home",
    "c5c2ec9d-12e5-441e-a323-3cab90417cb5": "11_perfil usuario",
    "61c46889-adfa-437f-b987-0695e89017e9": "04_pago",
    "d12245cc-1680-458d-89dd-4f0d7fb22724": "01_Store",
    "ce0ebaea-7e43-423b-8c99-034149a437dc": "09_pregunta mmpi",
    "27af05a1-98d4-4dca-b4bc-6479f1a628d3": "03_reset pass",
    "e73b655d-d3ec-4dcc-a55c-6e0293422bde": "960 grid - 16 columns",
    "ef07b413-721c-418e-81b1-33a7ed533245": "960 grid - 12 columns",
    "f39803f7-df02-4169-93eb-7547fb8c961a": "Template 1",
    "a8607c25-f272-4b8a-aef7-e840748521f2": "empty",
    "bb8abf58-f55e-472d-af05-a7d1bb0cc014": "default"
  };

  var uriRE = /^(\/#)?(screens|templates|masters|scenarios)\/(.*)(\.html)?/;
  window.lookUpURL = function(fragment) {
    var matches = uriRE.exec(fragment || "") || [],
        folder = matches[2] || "",
        canvas = matches[3] || "",
        name, url;
    if(dictionary.hasOwnProperty(canvas)) { /* search by name */
      url = folder + "/" + canvas;
    }
    return url;
  };

  window.lookUpName = function(fragment) {
    var matches = uriRE.exec(fragment || "") || [],
        folder = matches[2] || "",
        canvas = matches[3] || "",
        name, canvasName;
    if(dictionary.hasOwnProperty(canvas)) { /* search by name */
      canvasName = dictionary[canvas];
    }
    return canvasName;
  };
})(window);