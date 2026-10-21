http://localhost:8080/api
POST subir
GET mostrar
PUT editar

usuarios
{
  "correo": "@gmail.com",
  "password": "",
  "rol": "ADMIN",
  "activo": true
}

alumnos
{
  "numeroControl": "",
  "nombreCompleto": "",
  "carrera": "Ingeniería en Sistemas Computacionales",
  "semestre": 7,
  "estadoResidencia": "PENDIENTE",
  "habilidadesTecnicas": "Java, Spring Boot, PostgreSQL, Docker",
  "usuarios": {
    "idUsuario": 6
  }
}

empresas
{
  "razon_social": "Tech Solutions S.A. de C.V.",
  "sector": "Desarrollo de Software",
  "nombre_contacto": "Carlos Mendoza",
  "telefono": "2221234567",
  "direccion": "Av. Reforma #123, Puebla",
  "estado_verificaion": true,
  "usuarios": {
    "idUsuario": 5
  }
}

postulaciones
{
  "comentariosEmpresa": "El perfil encaja con lo que buscamos.",
  "alumno": {
    "numeroControl": "23940022"
  }
}

proyectos

{
  "titulo": "Desarrollo de PapelerIA",
  "descipcion": "Sistema de inventario y pedidos por WhatsApp", 
  "objetivo": "Automatizar proceso de ventas",
  "tecnologias_requeridos": "Flask, Gemini, WhatsApp API",
  "cupo_alumnos": 1,
  "estado": "ASIGNADO",
  "fecha_publicacion": "2026-10-21",
  "empresa": {
    "id_empresas": 11
  }
}

asesores

{
  "nombre_completo": "Roberto Sánchez",
  "departamentos": "Sistemas Computacionales",
  "maximo_alumnos": 5,
  "usuarios": {
    "idUsuario": 6 
  }
}

expedientes
{
  "tipo_documento": "ANTEPROYECTO", 
  "ruta_archivo_url": "/documentos/reporte_intel.pdf",
  "fecha_subida": "2026-10-21",
  "estado_aprobacion": true,
  "postulacion": {
    "idPostulacion": 4 
  }
}
