class SomeClass {
    public SomeClass() throws Exception {
        System.out.println("Construtor de SomeClass iniciado...");

        throw new Exception("Falha crítica no construtor: Não foi possível inicializar os recursos da SomeClass.");
    }
}