
const socketRoute = document.getElementById("ws-route").value;
const socket = new WebSocket(socketRoute);

//socket.onopen = () => socket.send("test message");


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
                hyperlink1.href = "@routes.HomeController.userProfile(repo.getAuthorName)";
                hyperlink1.innerHTML = repoInfo[j];
                cell1.appendChild(hyperlink1);
            }
            if(j == 1){
                const hyperlink2 = document.createElement("a");
                hyperlink2.href = "#";
                hyperlink2.innerHTML = repoInfo[j];
                cell2.appendChild(hyperlink2);
            }
            if(j == 2){
                cell3.innerHTML = repoInfo[j];
            }
            if(j == 3){
                cell4.innerHTML = repoInfo[j];
            }
        }


    }

}













