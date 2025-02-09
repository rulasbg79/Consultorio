package consultorio;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorArchivos {

    public static void guardarDoctores(List<Doctor> doctores, String archivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (Doctor doctor : doctores) {
                writer.write(doctor.toString());
                writer.newLine();
            }
            System.out.println("Doctores guardados exitosamente en: " + archivo);
        }
    }

    public static List<Doctor> cargarDoctores(String archivo) throws IOException {
        List<Doctor> doctores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                doctores.add(new Doctor(datos[0], datos[1], datos[2]));
            }
            System.out.println("Doctores cargados exitosamente desde: " + archivo);
        }
        return doctores;
    }

    public static void guardarPacientes(List<Paciente> pacientes, String archivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (Paciente paciente : pacientes) {
                writer.write(paciente.toString());
                writer.newLine();
            }
            System.out.println("Pacientes guardados exitosamente en: " + archivo);
        }
    }

    public static List<Paciente> cargarPacientes(String archivo) throws IOException {
        List<Paciente> pacientes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                pacientes.add(new Paciente(datos[0], datos[1]));
            }
            System.out.println("Pacientes cargados exitosamente desde: " + archivo);
        }
        return pacientes;
    }

    public static void guardarCitas(List<Cita> citas, String archivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            for (Cita cita : citas) {
                writer.write(cita.toString());
                writer.newLine();
            }
            System.out.println("Citas guardadas exitosamente en: " + archivo);
        }
    }

    public static List<Cita> cargarCitas(String archivo) throws IOException {
        List<Cita> citas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                citas.add(new Cita(datos[0], datos[1], datos[2], datos[3], datos[4]));
            }
            System.out.println("Citas cargadas exitosamente desde: " + archivo);
        }
        return citas;
    }
}