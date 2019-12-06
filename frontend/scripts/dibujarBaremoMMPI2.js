var paramData = [
  {
    type: "scatter",
    toolTipContent: "<b>Valor:</b>{y}",
    dataPoints: [
      { label: "k", y: 10 },
      { label: "l", y: 23 },
      { label: "v", y: 81 },
      { label: "s", y: 81 }
    ]
  },
  {
    type: "scatter",
    toolTipContent: "<b>Valor:</b>{y}",
    dataPoints: [
      { label: "k", y: 13 },
      { label: "l", y: 24 },
      { label: "v", y: 71 },
      { label: "s", y: 70 }
    ]
  },
  {
    type: "scatter",
    toolTipContent: "<b>Valor:</b>{y}",
    dataPoints: [
      { label: "k", y: 9 },
      { label: "l", y: 21 },
      { label: "v", y: 72 },
      { label: "s", y: 69 }
    ]
  },
  {
    type: "scatter",
    toolTipContent: "<b>Valor:</b>{y}",
    dataPoints: [
      { label: "k", y: 11 },
      { label: "l", y: 17 },
      { label: "v", y: 70 },
      { label: "s", y: 99 }
    ]
  },
  {
    type: "scatter",
    toolTipContent: "<b>Valor:</b>{y}",
    dataPoints: [
      { label: "k", y: 6 },
      { label: "l", y: 28 },
      { label: "v", y: 66 },
      { label: "s", y: 82 }
    ]
  }
];

function getBaremoData() {
  return paramData;
}

function dibujar() {
  var data = getBaremoData();
  var chart = new CanvasJS.Chart("chartContainer", {
    animationEnabled: true,
    zoomEnabled: true,
    axisX: {
      title: "Subescala"
    },
    axisY: {
      title: "Valor"
    },
    data: data
  });
  chart.render();
}
