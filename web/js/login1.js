$(
    function (){
        $("#username").autocomplete(
            {
                source:"/queryName.action"
            }
        );
    }
)