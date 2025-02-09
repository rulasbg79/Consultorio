package consultorio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaConsultorio {
    private List<Doctor> doctores;
    private List<Paciente> pacientes;
    private List<Cita> citas;
    private Administrador administrador;
    private GestorArchivos gestorArchivos;

    public SistemaConsultorio() {
        this.doctores = new ArrayList<>();
        this.pacientes = new ArrayList<>();
        this.citas = new ArrayList<>();
        this.gestorArchivos = new GestorArchivos();
        this.administrador = new Administrador("admin", "admin123"); // Credenciales predeterminadas
    }

    public void iniciarSistema() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al Sistema de Consultorio");

        // Autenticación
        System.out.print("Ingrese su ID: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contrasena = scanner.nextLine();

        if (administrador.autenticar(id, contrasena)) {
            System.out.println("Autenticación exitosa.");
            menuPrincipal();
        } else {
            System.out.println("Autenticación fallida. Saliendo del sistema...");
        }
    }

    private void menuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\nMenú Principal");
            System.out.println("1. Dar de alta doctor");
            System.out.println("2. Dar de alta paciente");
            System.out.println("3. Crear cita");
            System.out.println("4. Ver citas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    darAltaDoctor();
                    break;
                case 2:
                    darAltaPaciente();
                    break;
                case 3:
                    crearCita();
                    break;
                case 4:
                    verCitas();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    private void darAltaDoctor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del doctor: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese el nombre completo del doctor: ");
        String nombreCompleto = scanner.nextLine();
        System.out.print("Ingrese la especialidad del doctor: ");
        String especialidad = scanner.nextLine();

        Doctor doctor = new Doctor(id, nombreCompleto, especialidad);
        doctores.add(doctor);
        try {
            GestorArchivos.guardarDoctores(doctores, "src/main/resources/doctores.csv");
            System.out.println("Doctor registrado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar el doctor: " + e.getMessage());
        }
    }

    private void darAltaPaciente() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del paciente: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese el nombre completo del paciente: ");
        String nombreCompleto = scanner.nextLine();

        Paciente paciente = new Paciente(id, nombreCompleto);
        pacientes.add(paciente);
        try {
            GestorArchivos.guardarPacientes(pacientes, "src/main/resources/pacientes.csv");
            System.out.println("Paciente registrado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar el paciente: " + e.getMessage());
        }
    }

    private void crearCita() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID de la cita: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese la fecha y hora de la cita (YYYY-MM-DD HH:MM): ");
        String fechaHora = scanner.nextLine();
        System.out.print("Ingrese el motivo de la cita: ");
        String motivo = scanner.nextLine();
        System.out.print("Ingrese el ID del doctor: ");
        String idDoctor = scanner.nextLine();
        System.out.print("Ingrese el ID del paciente: ");
        String idPaciente = scanner.nextLine();

        Cita cita = new Cita(id, fechaHora, motivo, idDoctor, idPaciente);
        citas.add(cita);
        try {
            GestorArchivos.guardarCitas(citas, "src/main/resources/citas.csv");
            System.out.println("Cita creada exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar la cita: " + e.getMessage());
        }
    }

    private void verCitas() {
        try {
            List<Cita> citas = GestorArchivos.cargarCitas("src/main/resources/citas.csv");
            if (citas.isEmpty()) {
                System.out.println("No hay citas registradas.");
            } else {
                System.out.println("\nLista de Citas:");
                for (Cita cita : citas) {
                    System.out.println("ID: " + cita.getId());
                    System.out.println("Fecha y Hora: " + cita.getFechaHora());
                    System.out.println("Motivo: " + cita.getMotivo());
                    System.out.println("ID Doctor: " + cita.getIdDoctor());
                    System.out.println("ID Paciente: " + cita.getIdPaciente());
                    System.out.println("-----------------------------");
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar las citas: " + e.getMessage());
        }
    }
}