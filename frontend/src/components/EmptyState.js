import React from "react";

export default function EmptyState(){
    return(
        <div className="col-sm" style={style.align}>
            <h3>Belum ada item yang dipilih</h3>
            <h6>klik salah satu di daftar Menu</h6>
        </div>
    );
}

const style = {
    align : {
        textAlign: "center"
    }
}