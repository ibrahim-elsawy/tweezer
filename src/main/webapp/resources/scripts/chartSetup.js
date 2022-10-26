const dataUrl = `http://localhost:8080/tweezer/sentiment/${kafka_info.msgID}`;
//const dataUrl = "http://localhost:8080/tweezer/sentiment/WeUqsBud3R";

let stateData = {
  neu: 0,
  pos: 0,
  neg: 0,
};


const data = {
	labels: [
      "Neutral", //red
      "Postive", //blue
      "Negative", //yellow
    ],
    datasets: [
      {
        label: "My First Dataset",
        data: [stateData.neu, stateData.pos, stateData.neg],
        backgroundColor: [
          "rgb(255, 99, 132)",
          "rgb(54, 162, 235)",
          "rgb(255, 205, 86)",
        ],
        hoverOffset: 4,
      },
    ],
  };

const config = {
    type: "pie",
    data: data,
  };
var myChart = new Chart(document.getElementById("myChart"), config);


let nIntervId;

const chartUpdater = (data)=>{
	//.......
	console.log(data);
	if(data.status){
		myChart.data.datasets[0].data = [
			data.neutral,
			data.postive,
			data.negative];
		myChart.update();
		if(data.neutral+data.postive+data.negative > 10){
			clearInterval(nIntervId);
		}
	}
	else{
		console.error("id data is not found!");
		//clearInterval(nIntervId);
	}
};

const startFetcher = ()=>{
	fetch(dataUrl)
		.then((response) => response.json())
		.then(chartUpdater)
		.catch(err => console.error(err));

};
const startListner = ()=>{
	console.log("the sumbit is clicked ...........");
	nIntervId = setInterval(startFetcher, 10000);
};

if (kafka_info.msgID !== ""){
	console.log(kafka_info);
	startListner();
}
//document.getElementById("send88").addEventListener("click", startListner);


/*
import { Kafka } from "kafkajs";

const kafka = new Kafka({
  // clientId: "my-app",
  brokers: ["localhost:9092"],
  connectionTimeout: 3000,
});

const consumer = kafka.consumer({ groupId: "now" });



const start = async () => {
  await consumer.connect();
  await consumer.subscribe({ topic: "main4", fromBeginning: true });

  await consumer.run({
    eachMessage: async ({ message }) => {
      console.log({
        key: message.key.toString(),
        value: message.value.toString(),
        headers: message.headers,
      });

      switch (message.value.toString().split("#*#")[0]) {
        case "NEU":
          stateData.neu += 1;
          break;

        case "POS":
          stateData.pos += 1;
          break;

        case "NEG":
          stateData.neg += 1;
          break;

        default:
          console.error("no matching for incoming msg!!!!!!!!!!!!!!!!");
      }

    },
  });
};

start();
*/

/*import {Kafka} from 'kafkajs';

const kafka = new Kafka({
  clientId: 'my-app',
  brokers: ['localhost:9092'],
})

const consumer = kafka.consumer({ groupId: 'python-consumer' });

let stateData = {
	'neu':0,
	'pos':0,
	'neg':0,
	 };
	 
const start =  ()=>
{	 
	
	
	consumer.connect();
	consumer.subscribe({ topic: 'main4', fromBeginning: true });
	
	
	
	consumer.run({
	    eachMessage:  ({ message }) => {
	        console.log({
	            key: message.key.toString(),
	            value: message.value.toString(),
	            headers: message.headers,
	        })
	        
	        
			switch(message.value.toString().split("#*#")[0]) {
				
			  case 'NEU':
			    stateData.neu += 1;
			    break;
			    
			  case 'POS':
			    stateData.pos += 1;
			    break;
			    
			  case 'NEG':
			  	stateData.neg += 1;
			  	break;
			   
			  default:
			    console.error("no matching for incoming msg!!!!!!!!!!!!!!!!");
			}
	
			const data = {
			  labels: [
			    'Neutral', //red
			    'Postive', //blue
			    'Negative' //yellow
			  ],
			  datasets: [{
			    label: 'My First Dataset',
			    data: [stateData.neu, stateData.pos, stateData.neg],
			    backgroundColor: [
			      'rgb(255, 99, 132)',
			      'rgb(54, 162, 235)',
			      'rgb(255, 205, 86)'
			    ],
			    hoverOffset: 4
			  }]
			};
			
			
			const config = {
			  type: 'pie',
			  data: data,
			};
			var myChart = new Chart(
			    document.getElementById('myChart'),
			    config
			  );
			  
			  
			  
	    },
	});

};

start();
*/
