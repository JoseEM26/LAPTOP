import React from 'react'
import CrudTableRow from './CrudTableRow';

const CrudTable = ({ data ,deleteData,setDataToEdit}) => {
    return (
        <div>
            <h3>Tabla De Personajes de Dragon Ball</h3>
            <table>
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Raza</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    {data.length === 0 ? (
                        <tr><td colSpan="3">Tabla Vacia</td></tr>
                    ) : (
                        data.map((el) => (
                            <CrudTableRow
                                key={el.id}
                                el={el} 
                                deleteData={deleteData}
                                setDataToEdit={setDataToEdit}
                                />
                        ))
                    )}
                </tbody>
            </table>
        </div>
    )
}
export default CrudTable;
