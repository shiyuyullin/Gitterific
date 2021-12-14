
const socketRoute = document.getElementById("ws-route").value;
const socket = new WebSocket(socketRoute);


socket.onmessage = function(event){

    const arr = event.data.split("\n");
    console.log(arr);
    const table = document.getElementById(arr[0]);

    for(let i = 1; i < arr.length; i++){
        const line = arr[i];
        const repoInfo = line.split(" ");
        const row = table.insertRow(1);
        const cell1 = row.insertCell(0);
        const cell2 = row.insertCell(1);
        const cell3 = row.insertCell(2);
        const cell4 = row.insertCell(3);
        for(let j = 0; j < repoInfo.length; j++){
            if(j == 0){
                const hyperlink1 = document.createElement("a");
                hyperlink1.href = `/user/${repoInfo[j]}`;
                hyperlink1.innerHTML = repoInfo[j];
                cell1.appendChild(hyperlink1);
            }
            if(j == 1){
                const hyperlink2 = document.createElement("a");
                hyperlink2.href = `/repo/${repoInfo[j-1]}/${repoInfo[j]}`;
                hyperlink2.innerHTML = repoInfo[j];
                cell2.appendChild(hyperlink2);
            }
            if(j == 2){
                cell3.innerHTML = repoInfo[j];
            }
            if(j == 3){
                let date = "";
                for(let k = j; k < repoInfo.length; k++){
                    date = date + repoInfo[k] + " ";
                }
                cell4.innerHTML = date;
            }
        }
    }

}













