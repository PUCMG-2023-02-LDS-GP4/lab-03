import { Paper, TableContainer, TableHead, TableRow, TableCell, TableBody, Table as MUITable } from "@mui/material";

function Table({columns, children}) {

    return (
        <Paper elevation={0} sx={{ width: '100%', overflow: 'hidden' }}>
            <TableContainer sx={{ maxHeight: 440 }}>
                <MUITable size="small" stickyHeader aria-label="sticky table">
                    <TableHead>
                        <TableRow>
                            {columns.map((column) => (
                                <TableCell
                                    key={column.id}
                                    align={column.align || 'left'}
                                    style={{ minWidth: column.minWidth }}
                                >
                                    {column.label}
                                </TableCell>
                            ))}
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {children}
                    </TableBody>
                </MUITable>
            </TableContainer>
        </Paper>
    );
}

export default Table;