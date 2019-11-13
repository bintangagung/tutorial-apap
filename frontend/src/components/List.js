import React from "react";
import Item from "./Item";

export default function List({tittle, items, onItemClick}) {
    return (
        <>
        <h3 style={styles.heading}>{tittle}</h3>
        <div className="list-group">
            {items.map(item => (
                <Item key={item.id} item={item} onChange={onItemClick} />
            ))}
        </div>
        </>  
    );
}

const styles = {
    heading: {
        fontFamily: "courier new"
    }
};