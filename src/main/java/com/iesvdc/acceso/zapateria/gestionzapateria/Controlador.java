package com.iesvdc.acceso.zapateria.gestionzapateria;



import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author profesor
 */

@RestController
@RequestMapping("/rest")
@CrossOrigin
public class Controlador {
    
    // RepositorioClientes repositorioCliente;
    
    @Autowired
    RepositorioCliente repoClient;
    
    @Autowired
    RepositorioEmpleado repoEmpl;
    
    @Autowired
    RepositorioCodPos repoCodPos;
    
    @Autowired
    RepositorioClienteDireccion repoClientDirec;
    
    @Autowired
    RepositorioEmpleadoDireccion repoEmplDirec;

   // Get All Clientes
    @GetMapping("/clientes")
    public List<Cliente> getAllClientes() {
        return repoClient.findAll();
    }
    
    // Get a Single Client
    @GetMapping("/cliente/{id}")
    public Cliente getCliente(@PathVariable(value = "id") Long clienteId) {
        return repoClient.findById(clienteId)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente", "id", clienteId));
    }
  
    // Get All Empleados
    @GetMapping("/empleados")
    public List<Empleado> getAllEmpleados() {
        return repoEmpl.findAll();
    }
    
    @GetMapping("/empleado/{id}")
    public Empleado getEmpleado(@PathVariable(value = "id") Long empleadoId) {
        return repoEmpl.findById(empleadoId)
                .orElseThrow(() -> new ResourceNotFoundException("Empleado", "id", empleadoId));
    }
    
    
    // Get All Clientes
    @GetMapping("/codpos")
    public List<CodPos> getAllCodPos() {
        return repoCodPos.findAll();
    }
    
     @PostMapping(value="/codpos", consumes={"application/json"})
    @ResponseBody public CodPos createCodPos(@Valid @RequestBody CodPos codpos) {
        System.out.println("\n\n\nINTENTANDO GUARDAR CODPOS CP="+codpos.getCp());
        return repoCodPos.save(codpos);
}
    
    
    // Get All Clientes Direcciones
    @GetMapping("/clientes/direcciones")
    public List<ClienteDireccion> getAllClientesDirecciones() {
        return repoClientDirec.findAll();
    }
    
    // Get All ClienteDireccion
    @GetMapping("/cliente/{idCli}/direccion")
    public List<ClienteDireccion> getClienteDireccionByCliente(@PathVariable(value = "idCli") Long idCli) {
    	Cliente cliente = repoClient.findById(idCli).get();
        return cliente.getClienteDireccionList();
}
    
    // Get All Clientes Direcciones
    @GetMapping("/empleados/direcciones")
    public List<EmpleadoDireccion> getAllEmpleadosDirecciones() {
        return repoEmplDirec.findAll();
    }
    
    @GetMapping("/empleado/{idCli}/direccion")
    public List<EmpleadoDireccion> getClienteDireccionByEmpleado(@PathVariable(value = "idEm") Long idEm) {
    	Empleado empleado = repoEmpl.findById(idEm).get();
        return empleado.getEmpleadoDireccionList();
    }
   /*
    // Get All Notes
    @GetMapping("/cliente/{id}")
    public List<ClienteDireccion> getDireccions(Long id) {
        return repoClient.();
    }
   */

    
}
