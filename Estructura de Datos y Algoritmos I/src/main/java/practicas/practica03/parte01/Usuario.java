package practicas.practica03.parte01;

import java.util.Objects;

public class Usuario implements Comparable<Usuario> {
	private final String usuarioId;
	private String documentoId;
	private String direccion;

	public Usuario(String usuarioId) {
		this.usuarioId = usuarioId;

	}

	public String getUsuarioId() {
		return this.usuarioId;
	}

	public void setDocumentoId(String documentoId) {
		this.documentoId = documentoId;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return this.usuarioId + (this.documentoId == null ? "" : " <" + this.documentoId + ">")
				+ (this.direccion == null ? "" : " - " + this.direccion);

	}

	@Override
	public int compareTo(Usuario o) {
		return this.usuarioId.compareTo(o.usuarioId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || this.getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(usuarioId, other.usuarioId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(usuarioId);
	}
}
