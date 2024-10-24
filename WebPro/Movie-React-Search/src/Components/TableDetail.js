import React from "react";

function TableDetail(props) {
  return (
    <tr>
      <td>
        <img
          alt={props.id}
          src={props.image}
          style={{ width: "200px" }}
          onClick={props.onClick} // add onClick event handler
        />
      </td>
      <td>{props.name}</td>
      <td>{props.year}</td>
    </tr>
  );
}

export default TableDetail;
